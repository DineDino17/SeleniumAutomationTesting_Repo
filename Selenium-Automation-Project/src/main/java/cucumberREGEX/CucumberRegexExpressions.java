package cucumberREGEX;

public class CucumberRegexExpressions {
	

	    public static final String STRING = "([^\"]*)";
	    public static final String INTEGER = "(\\d+)";
	    public static final String FLOAT = "([0-9]*\\.[0-9]+)";
	    public static final String DOUBLE = "([+-]?\\d*\\.\\d+(?:[eE][+-]?\\d+)?)";
	    public static final String LONG = "(\\d{5,18})";
	    public static final String ALPHABET = "([A-Za-z]+)";
	    public static final String ALPHANUMERIC = "([A-Za-z0-9]+)";
	    public static final String EMAIL = "([A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,})";
	    public static final String DATE = "(\\d{2}-\\d{2}-\\d{4})";
	    public static final String TIME = "(\\d{2}:\\d{2}:\\d{2})";

	    public static final String MULTILINE = "(?s)(.*)";
	    public static final String TABS = "([\\t]+)";
	    public static final String SPACES = "( +)";
	    public static final String WHITESPACE = "([\\s]+)";


}
