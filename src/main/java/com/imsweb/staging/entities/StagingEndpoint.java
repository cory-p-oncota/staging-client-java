/*
 * Copyright (C) 2014 Information Management Services, Inc.
 */
package com.imsweb.staging.entities;

import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Property;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import com.imsweb.decisionengine.Endpoint;

@JsonPropertyOrder({"type", "value", "result_key"})
@Embedded
public class StagingEndpoint implements Endpoint {

    @Property("type")
    private EndpointType _type;
    @Property("value")
    private String _value;
    @Property("result_key")
    private String _resultKey;

    public StagingEndpoint() {
    }

    public StagingEndpoint(EndpointType type, String value) {
        _type = type;
        _value = value;
    }

    @Override
    @JsonProperty("type")
    public EndpointType getType() {
        return _type;
    }

    public void setType(EndpointType type) {
        _type = type;
    }

    @Override
    @JsonProperty("value")
    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

    @Override
    @JsonProperty("result_key")
    public String getResultKey() {
        return _resultKey;
    }

    public void setResultKey(String resultKey) {
        _resultKey = resultKey;
    }

}
