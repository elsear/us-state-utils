package org.sfstudy.homework.configuration;

/**
 * An object with org.sfstudy.homework.configuration stored in map.
 * Configuration contains information about data to generate XML, HTML.
 */
public interface Configuration {
    String getConfigurationValue(String key) throws Exception;
}