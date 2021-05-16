package com.go.demo.common.response;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class PageResult<T> extends ListResult<T> {
    private int pageNo;
    private int pageSize;
    private long totalCount;
}
