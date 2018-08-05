package configuration;

import exception.EmptyConfigurationException;
import exception.NullConfigurationException;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class USStatesConfiguration implements DualConfiguration{
    private Map<String, String> configuration;
    private Map<String, String> reversedConfiguration;

    public USStatesConfiguration(Map<String, String> configuration) throws EmptyConfigurationException {
        this.configuration = configuration;
        reverseConfiguration();
    }

    private void reverseConfiguration() throws EmptyConfigurationException {
        if(configuration == null) throw new EmptyConfigurationException("There is no configuration to reverse.");

        reversedConfiguration = configuration.entrySet()
                        .stream()
                        .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));
    }

    @Override
    public String getConfigurationValue(String key) throws NullConfigurationException {
        String value = configuration.get(key);
        if(value == null) throw new NullConfigurationException("Configuration does not contain such entry.");
        return value;
    }

    @Override
    public String getReversedConfigurationValue(String key) throws NullConfigurationException {
        String value = reversedConfiguration.get(key);
        if(value == null) throw new NullConfigurationException("Configuration does not contain such entry.");
        return value;
    }

    @Override
    public Set<String> getConfigurationKeys() {
        return configuration.keySet();
    }
}