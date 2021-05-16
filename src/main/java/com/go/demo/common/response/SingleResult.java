package com.go.demo.common.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class SingleResult<T> extends BasicResult {
    T data;
}
