package healthcare-matcher;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class healthcare-matcherApplication extends Application<healthcare-matcherConfiguration> {

    public static void main(final String[] args) throws Exception {
        new healthcare-matcherApplication().run(args);
    }

    @Override
    public String getName() {
        return "healthcare-matcher";
    }

    @Override
    public void initialize(final Bootstrap<healthcare-matcherConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final healthcare-matcherConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
