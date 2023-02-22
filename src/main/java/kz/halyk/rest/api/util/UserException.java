package kz.halyk.rest.api.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class UserException extends Exception {
  private String exceptionMessage;
}
