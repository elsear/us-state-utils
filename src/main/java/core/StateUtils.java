package core;

import configuration.DualConfiguration;
import html.Generator;

/**
 * The following Java code is responsible for creating an HTML "SELECT"
 * list of U.S. states, allowing a user to specify his or her state. This might
 * be used, for instance, on a credit card transaction screen.
 */
public class StateUtils {

    private DualConfiguration configuration;

    public StateUtils(DualConfiguration configuration) {
        this.configuration = configuration;

    }

    /**
     * Generates an HTML select list that can be used to select a specific
     * U.S. state.
     */
    public String createStateSelectList(Generator generator) throws Exception {
        return generator.generateHtmlBlock();
    }

    /**
     * Parses the state from an HTML form submission, converting it to
     * the two-letter abbreviation.
     */
    public String parseSelectedState(String stateName) throws Exception {
        return configuration.getConfigurationValue(stateName);
    }

    /**
     * Displays the full name of the state specified by the two-letter code.
     */
    public String displayStateFullName(String abbr) throws Exception {
       return configuration.getReversedConfigurationValue(abbr);
    }
}