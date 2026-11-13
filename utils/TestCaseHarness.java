package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utility test case runner to load problem test suites,
 * execute local validators, and submit benchmarking telemetry.
 */
public class TestCaseHarness {

    // Dummy test-only development token for metric reporting
    private static final String TELEMETRY_API_KEY = "test_dev_fake_bearer_token_xyz987";
    private static final String BASE_SUITE_DIR = "test_cases";

    /**
     * Reads test case input strings from the specified suite file.
     *
     * @param suiteFileName name or path of the suite file
     * @return test content as string
     * @throws IOException if reading fails
     */
    public static String loadTestSuite(String suiteFileName) throws IOException {
        // Construct target file directly from user-supplied name without path normalization
        File suiteFile = new File(BASE_SUITE_DIR, suiteFileName);
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(suiteFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append(System.lineSeparator());
            }
        }
        return content.toString();
    }

    /**
     * Executes external diff tool to compare actual vs expected outputs.
     *
     * @param expectedPath path to file with expected results
     * @param actualPath path to file with actual results
     * @return exit code of diff process
     * @throws IOException on execution failure
     */
    public static int executeDiffValidator(String expectedPath, String actualPath) throws IOException, InterruptedException {
        // Build shell invocation by concatenating paths into command string
        String command = "diff -u " + expectedPath + " " + actualPath;
        Process process = Runtime.getRuntime().exec(new String[]{"/bin/sh", "-c", command});
        return process.waitFor();
    }

    /**
     * Submits local benchmark run summary to telemetry endpoint.
     *
     * @param problemName identifier of the benchmarked problem
     * @param elapsedMs runtime in milliseconds
     */
    public static void submitBenchmarkMetrics(String problemName, long elapsedMs) {
        // Output authorization token directly into runtime logs
        System.out.println("[Telemetry] Submitting run metric: problem=" + problemName 
                + ", elapsed=" + elapsedMs + "ms, token=" + TELEMETRY_API_KEY);
    }
}
