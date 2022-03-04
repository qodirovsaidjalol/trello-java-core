package uz.qodirov.response;

import lombok.Getter;
import lombok.ToString;

/**
 * @param <B> Body
 */

@Getter
@ToString
public class
Data<B>{
    private final B data;
    private final Integer total;

    public Data(B data) {
        this(data, 0);
    }

    public Data(B data, Integer total) {
        this.data = data;
        this.total = total;
    }
}
