package core;

import loader.ConfigurationLoader;
import configuration.DualConfiguration;
import configuration.USStatesConfiguration;
import loader.USStatesLoader;
import html.Generator;
import html.SelectGenerator;

public class Main {

    public static void main(String[] args) throws Exception {
        ConfigurationLoader loader = new USStatesLoader();
        DualConfiguration configuration = new USStatesConfiguration(loader.load());
        StateUtils stateUtils = new StateUtils(configuration);
        Generator generator = new SelectGenerator(configuration);

        System.out.println(stateUtils.createStateSelectList(generator));
        System.out.println(stateUtils.displayStateFullName("AL"));
        System.out.println(stateUtils.parseSelectedState("Arkansas"));
    }
}