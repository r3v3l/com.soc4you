package filters;


import play.filters.csrf.CSRFFilter;
import play.http.DefaultHttpFilters;

import javax.inject.Inject;

/**
 * Created by adrian on 16.08.16.
 */
public class CsrfFilter extends DefaultHttpFilters {

    @Inject
    public CsrfFilter(CSRFFilter csrfFilter) {
        super(csrfFilter);
    }

}
