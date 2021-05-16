package com.go.demo.common.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class ListResult<T> extends BasicResult {
    private List<T> data;
}
