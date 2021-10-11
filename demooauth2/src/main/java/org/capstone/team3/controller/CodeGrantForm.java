package org.capstone.team3.controller;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CodeGrantForm {

    private String client_id;
    private String redirect_uri;
    private String response_type;
    private String scope;
}
