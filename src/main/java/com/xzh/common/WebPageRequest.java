package com.xzh.common;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
public class WebPageRequest implements Serializable {

    public int page = 0;

    public int size = 10;


}
