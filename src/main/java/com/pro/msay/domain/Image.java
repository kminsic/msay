package com.pro.msay.domain;


import javax.persistence.Table;

@Table
public class Image extends Timestamped{
    private String imgUrl;
    private String modifiedAt;
}
