/*
 * Copyright (C) 2014 Information Management Services, Inc.
 */
package com.imsweb.decisionengine.basic;

import java.util.ArrayList;
import java.util.List;

import com.imsweb.decisionengine.Input;

public class BasicInput implements Input {

    private String _key;
    private String _values;
    private String _default;
    private String _table;
    private Boolean _usedForStaging;

    // parsed fields
    private List<BasicStringRange> _parsedValues = new ArrayList<BasicStringRange>();

    /**
     * Default constrctor
     */
    public BasicInput() {
    }

    /**
     * Construct with an input key
     * @param key input key
     */
    public BasicInput(String key) {
        setKey(key);
    }

    /**
     * Construct with an input key and table
     * @param key input key
     * @param table table
     */
    public BasicInput(String key, String table) {
        setKey(key);
        setTable(table);
    }

    @Override
    public String getKey() {
        return _key;
    }

    public void setKey(String key) {
        _key = key;
    }

    public String getRawValues() {
        return _values;
    }

    public void setRawValues(String values) {
        _values = values;
    }

    @Override
    public String getDefault() {
        return _default;
    }

    public void setDefault(String aDefault) {
        _default = aDefault;
    }

    @Override
    public String getTable() {
        return _table;
    }

    public void setTable(String table) {
        _table = table;
    }

    @Override
    public List<BasicStringRange> getValues() {
        return _parsedValues;
    }

    public void setValues(List<BasicStringRange> parsedValues) {
        _parsedValues = parsedValues;
    }

    @Override
    public Boolean getUsedForStaging() {
        return _usedForStaging;
    }

    public void setUsedForStaging(Boolean usedForStaging) {
        _usedForStaging = usedForStaging;
    }
}
