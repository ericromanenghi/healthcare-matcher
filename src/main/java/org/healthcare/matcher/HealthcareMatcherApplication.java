package org.healthcare.matcher;

import io.dropwizard.Application;
import io.dropwizard.jdbi3.JdbiFactory;
import io.dropwizard.jdbi3.bundles.JdbiExceptionsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.healthcare.matcher.repositories.HospitalRepository;
import org.healthcare.matcher.repositories.daos.HospitalDao;
import org.healthcare.matcher.resources.HospitalResource;
import org.jdbi.v3.core.Jdbi;

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
        bootstrap.addBundle(new JdbiExceptionsBundle());
    }

    @Override
    public void run(final HealthcareMatcherConfiguration configuration,
                    final Environment environment) {
        final JdbiFactory factory = new JdbiFactory();
        final Jdbi jdbi = factory.build(environment, configuration.getDataSourceFactory(), "sqlite");
        environment.jersey().register(new HospitalResource(new HospitalRepository(jdbi.onDemand(HospitalDao.class))));
    }

}
