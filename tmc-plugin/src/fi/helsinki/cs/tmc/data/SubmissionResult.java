package fi.helsinki.cs.tmc.data;

import com.google.gson.annotations.SerializedName;

import fi.helsinki.cs.tmc.stylerunner.validation.ValidationResult;

import java.util.Collections;
import java.util.List;

@Deprecated
public class SubmissionResult {

    @Deprecated
    public static enum Status {
        OK,
        FAIL,
        ERROR
    }

    @Deprecated
    public static enum TestResultStatus {
        ALL,
        SOME,
        NONE
    }

    @SerializedName("status")
    private Status status;

    @SerializedName("error")
    private String error; // e.g. compile error

    @SerializedName("test_cases")
    private List<TestCaseResult> testCases;

    @SerializedName("solution_url")
    private String solutionUrl;

    @SerializedName("points")
    private List<String> points;

    @SerializedName("missing_review_points")
    private List<String> missingReviewPoints;

    @SerializedName("feedback_questions")
    private List<FeedbackQuestion> feedbackQuestions;

    @SerializedName("feedback_answer_url")
    private String feedbackAnswerUrl;

    @SerializedName("valgrind")
    private String valgrindOutput;

    private ValidationResult validationResult;

    public SubmissionResult() {
        status = Status.ERROR;
        error = null;
        testCases = Collections.emptyList();
        points = Collections.emptyList();
        missingReviewPoints = Collections.emptyList();
        feedbackQuestions = Collections.emptyList();
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<TestCaseResult> getTestCases() {
        return testCases;
    }

    public void setTestCases(List<TestCaseResult> testCases) {
        this.testCases = testCases;
    }

    public String getSolutionUrl() {
        return solutionUrl;
    }

    public void setSolutionUrl(String solutionUrl) {
        this.solutionUrl = solutionUrl;
    }

    public List<String> getPoints() {
        return points;
    }

    public void setPoints(List<String> points) {
        this.points = points;
    }

    public List<String> getMissingReviewPoints() {
        return missingReviewPoints;
    }

    public void setMissingReviewPoints(List<String> missingReviewPoints) {
        this.missingReviewPoints = missingReviewPoints;
    }

    public List<FeedbackQuestion> getFeedbackQuestions() {
        return feedbackQuestions;
    }

    public void setFeedbackQuestions(List<FeedbackQuestion> feedbackQuestions) {
        this.feedbackQuestions = feedbackQuestions;
    }

    public String getFeedbackAnswerUrl() {
        return feedbackAnswerUrl;
    }

    public void setFeedbackAnswerUrl(String feedbackAnswerUrl) {
        this.feedbackAnswerUrl = feedbackAnswerUrl;
    }

    public void setValidationResult(final ValidationResult result) {

        this.validationResult = result;
    }

    public ValidationResult getValidationResult() {

        return validationResult;
    }

    public String getValgrindOutput() {

        return valgrindOutput;
    }

    public TestResultStatus getTestResultStatus() {

        int testsFailed = 0;

        for (TestCaseResult tcr : testCases) {
            if (!tcr.isSuccessful()) {
                testsFailed++;
            }
        }

        if (testsFailed == testCases.size()) {
            return TestResultStatus.ALL;
        }

        if (testsFailed != 0) {
            return TestResultStatus.SOME;
        }

        return TestResultStatus.NONE;
    }

    public boolean validationsFailed() {
        return this.validationResult == null ?
                false : !this.validationResult.getValidationErrors().isEmpty();
    }
}
