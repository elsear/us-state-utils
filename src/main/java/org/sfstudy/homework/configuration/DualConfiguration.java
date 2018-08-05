package org.sfstudy.homework.configuration;

import java.util.Set;

public interface DualConfiguration extends Configuration {
    String getReversedConfigurationValue(String key) throws Exception;
    Set<String> getConfigurationKeys();
}