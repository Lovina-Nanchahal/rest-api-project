package com.example.demo.model;

public enum SearchOperation {
    CONTAINS, DOES_NOT_CONTAIN, EQUAL, NOT_EQUAL, BEGINS_WITH,
    DOES_NOT_BEGIN_WITH, ENDS_WITH, DOES_NOT_END_WITH,
    GREATER_THAN, GREATER_THAN_EQUAL, LESS_THAN,
    LESS_THAN_EQUAL, INCLUDES, EXCLUDES;

    public static final String[] SIMPLE_OPERATION_SET = {
            "cn", "nc", "eq", "ne", "bw", "bn", "ew",
            "en", "gt", "ge", "lt", "le", "in", "ex" };

    public static SearchOperation getSimpleOperation(final String input) {
        return switch (input) {
            case "cn" -> CONTAINS;
            case "nc" -> DOES_NOT_CONTAIN;
            case "eq" -> EQUAL;
            case "ne" -> NOT_EQUAL;
            case "bw" -> BEGINS_WITH;
            case "bn" -> DOES_NOT_BEGIN_WITH;
            case "ew" -> ENDS_WITH;
            case "en" -> DOES_NOT_END_WITH;
            case "gt" -> GREATER_THAN;
            case "ge" -> GREATER_THAN_EQUAL;
            case "lt" -> LESS_THAN;
            case "le" -> LESS_THAN_EQUAL;
            case "in" -> INCLUDES;
            case "ex" -> EXCLUDES;
            default -> null;
        };
    }
}
