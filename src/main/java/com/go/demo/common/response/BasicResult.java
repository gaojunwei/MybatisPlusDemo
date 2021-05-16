package com.go.demo.common.response;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@EqualsAndHashCode(callSuper=false)
public class BasicResult implements Serializable {

    private static final long serialVersionUID = -5809782578272943999L;
    
    private String code;
    private String msg;
    private String sn;
}
