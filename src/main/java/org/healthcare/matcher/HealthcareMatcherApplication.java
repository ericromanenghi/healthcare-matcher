package org.healthcare.matcher;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HealthcareMatcherApplication extends Application<HealthcareMatcherConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HealthcareMatcherApplication().run(args);
    }

    @Override
    public String getName() {
        return "HealthcareMatcher";
    }

    @Override
    public void initialize(final Bootstrap<HealthcareMatcherConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HealthcareMatcherConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
