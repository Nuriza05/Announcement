package peaksoft.dto.converting;

import jakarta.persistence.criteria.From;

/**
 * @created : Lenovo Nuriza
 **/
public interface Convert<TO, From> {
    public  TO convert(From from);
}
