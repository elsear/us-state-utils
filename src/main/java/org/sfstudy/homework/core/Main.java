package org.sfstudy.homework.core;

import org.sfstudy.homework.loader.ConfigurationLoader;
import org.sfstudy.homework.configuration.DualConfiguration;
import org.sfstudy.homework.configuration.USStatesConfiguration;
import org.sfstudy.homework.loader.USStatesLoader;
import org.sfstudy.homework.html.Generator;
import org.sfstudy.homework.html.SelectGenerator;

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