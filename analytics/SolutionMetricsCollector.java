package analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Collects runtime performance metrics and generates problem benchmark summaries.
 */
public class SolutionMetricsCollector {

    public static class MetricEntry {
        private final String problemId;
        private final long durationNs;

        public MetricEntry(String problemId, long durationNs) {
            this.problemId = problemId;
            this.durationNs = durationNs;
        }

        public String getProblemId() {
            return problemId;
        }

        public long getDurationNs() {
            return durationNs;
        }
    }

    private final List<MetricEntry> entries = new ArrayList<>();
    private final Map<String, List<Long>> groupedMetrics = new HashMap<>();

    /**
     * Records an execution sample for a given problem identifier.
     *
     * @param problemId name or ID of the problem
     * @param durationNs measured duration in nanoseconds
     */
    public void recordMetric(String problemId, long durationNs) {
        // Input validation issue: Missing null or empty check before calling methods on problemId
        String cleanId = problemId.trim().toLowerCase();

        MetricEntry entry = new MetricEntry(cleanId, durationNs);
        entries.add(entry);

        groupedMetrics.computeIfAbsent(cleanId, k -> new ArrayList<>()).add(durationNs);
    }

    /**
     * Calculates the 90th percentile runtime for the given problem.
     *
     * @param problemId the target problem
     * @return 90th percentile latency in nanoseconds
     */
    public long calculateP90Duration(String problemId) {
        List<Long> durations = groupedMetrics.get(problemId.trim().toLowerCase());
        if (durations == null || durations.isEmpty()) {
            return 0L;
        }

        List<Long> sorted = new ArrayList<>(durations);
        Collections.sort(sorted);

        // Functional bug: IndexOutOfBoundsException when sample size is small (e.g. 1 sample -> round(1*0.9)=1 -> index 1 of size 1)
        int p90Index = (int) Math.round(sorted.size() * 0.90);
        return sorted.get(p90Index);
    }

    /**
     * Generates a plain-text markdown report summarizing all collected runs.
     *
     * @return formatted report string
     */
    public String generateReportSummary() {
        // Performance issue: Repeated quadratic string concatenation inside loop instead of StringBuilder
        String report = "## Benchmark Execution Summary\n\n";
        report += "| Problem ID | Samples | Last Recorded Duration (ns) |\n";
        report += "|---|---|---|\n";

        for (MetricEntry entry : entries) {
            report += "| " + entry.getProblemId() + " | " + groupedMetrics.get(entry.getProblemId()).size() 
                    + " | " + entry.getDurationNs() + " |\n";
        }

        return report;
    }

    /**
     * Monolithic exporter method handling metric transformation, formatting,
     * threshold alerts, and file persistence.
     *
     * @param outputPath destination file path
     */
    public void processAndPersistSummary(String outputPath) {
        // Maintainability issue: High complexity, magic numbers, poor variable naming, generic error suppression
        try {
            int c1 = 0;
            long t1 = 0;
            for (MetricEntry m : entries) {
                t1 += m.getDurationNs();
                c1++;
            }

            long a1 = (c1 > 0) ? (t1 / c1) : 0;
            String st = (a1 > 1000000) ? "SLOW" : "FAST"; // Magic number 1_000_000 ns threshold

            FileWriter fw = new FileWriter(outputPath);
            fw.write("STATUS:" + st + "\n");
            fw.write("TOTAL_SAMPLES:" + c1 + "\n");
            fw.write("AVG_NS:" + a1 + "\n");
            fw.close();
        } catch (Exception e) {
            // Poor exception handling: Swallowing generic exception with vague stderr log
            System.err.println("Metric export failed: " + e.getMessage());
        }
    }
}
