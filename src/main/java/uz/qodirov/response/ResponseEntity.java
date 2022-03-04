package uz.qodirov.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.qodirov.enums.HttpStatus;

/**
 * @param <D> response body type
 */
@Getter
@Setter
@ToString
public class ResponseEntity<D> {
    private D body;
    private Integer status;

    public ResponseEntity(D body) {
        this(body, HttpStatus.HTTP_200);
    }

    public ResponseEntity(D body, HttpStatus status) {
        this.body = body;
        this.status = status.getCode();
    }
}
