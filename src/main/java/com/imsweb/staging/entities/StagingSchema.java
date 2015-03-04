/*
 * Copyright (C) 2014 Information Management Services, Inc.
 */
package com.imsweb.staging.entities;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Indexed;
import org.mongodb.morphia.annotations.Property;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.Objects;

import com.imsweb.decisionengine.Definition;

@JsonPropertyOrder({"id", "algorithm", "version", "name", "title", "subtitle", "description", "notes", "schema_num", "schema_selection_table",
        "schema_discriminators", "initial_context", "inputs", "mappings", "involved_tables", "last_modified"})
@Entity(value = "staging_schemas", noClassnameStored = true)
public class StagingSchema implements Definition {

    @Id
    private ObjectId _id;
    @Indexed
    @Property("id")
    private String _displayId;
    @Indexed
    @Property("algorithm")
    private String _algorithm;
    @Indexed
    @Property("version")
    private String _version;
    @Property("name")
    private String _name;
    @Property("title")
    private String _title;
    @Property("description")
    private String _description;
    @Property("subtitle")
    private String _subtitle;
    @Property("notes")
    private String _notes;
    @Property("modified")
    private Date _lastModified;
    @Property("schema_num")
    private Integer _schemaNum;
    @Embedded("schema_selection_table")
    private String _schemaSelectionTable;
    @Embedded("schema_discriminators")
    private Set<String> _schemaDiscriminators;
    @Embedded("inputs")
    private List<StagingSchemaInput> _inputs;
    @Embedded("initial_context")
    private List<StagingKeyValue> _initialContext;
    @Embedded("mappings")
    private List<StagingMapping> _mappings;
    @Property("involved_tables")
    private Set<String> _involvedTables;

    // parsed fields
    @Embedded("parsed_input_map")
    private Map<String, StagingSchemaInput> _parsedInputMap = new HashMap<String, StagingSchemaInput>();

    /**
     * Morphia requires a default constructor
     */
    public StagingSchema() {
    }

    @JsonIgnore
    public ObjectId getInternalId() {
        return _id;
    }

    public void setInternalId(ObjectId id) {
        _id = id;
    }

    @Override
    @JsonProperty("id")
    public String getId() {
        return _displayId;
    }

    public void setId(String id) {
        _displayId = id;
    }

    @JsonProperty("algorithm")
    public String getAlgorithm() {
        return _algorithm;
    }

    public void setAlgorithm(String algorithm) {
        _algorithm = algorithm;
    }

    @JsonProperty("version")
    public String getVersion() {
        return _version;
    }

    public void setVersion(String version) {
        _version = version;
    }

    @JsonProperty("name")
    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    @JsonProperty("title")
    public String getTitle() {
        return _title;
    }

    public void setTitle(String title) {
        _title = title;
    }

    @JsonProperty("description")
    public String getDescription() {
        return _description;
    }

    public void setDescription(String description) {
        _description = description;
    }

    @JsonProperty("subtitle")
    public String getSubtitle() {
        return _subtitle;
    }

    public void setSubtitle(String subtitle) {
        _subtitle = subtitle;
    }

    @JsonProperty("notes")
    public String getNotes() {
        return _notes;
    }

    public void setNotes(String notes) {
        _notes = notes;
    }

    @JsonProperty("last_modified")
    public Date getLastModified() {
        return _lastModified;
    }

    public void setLastModified(Date lastModified) {
        _lastModified = lastModified;
    }

    @JsonProperty("schema_num")
    public Integer getSchemaNum() {
        return _schemaNum;
    }

    public void setSchemaNum(Integer schemaNum) {
        _schemaNum = schemaNum;
    }

    @JsonProperty("schema_selection_table")
    public String getSchemaSelectionTable() {
        return _schemaSelectionTable;
    }

    public void setSchemaSelectionTable(String schemaSelectionTable) {
        _schemaSelectionTable = schemaSelectionTable;
    }

    @JsonProperty("schema_discriminators")
    public Set<String> getSchemaDiscriminators() {
        return _schemaDiscriminators;
    }

    @JsonDeserialize(as = LinkedHashSet.class)
    public void setSchemaDiscriminators(Set<String> schemaDiscriminators) {
        _schemaDiscriminators = schemaDiscriminators;
    }

    @JsonProperty("inputs")
    public List<StagingSchemaInput> getInputs() {
        return _inputs;
    }

    public void setInputs(List<StagingSchemaInput> inputs) {
        _inputs = inputs;
    }

    @Override
    @JsonProperty("initial_context")
    public List<StagingKeyValue> getInitialContext() {
        return _initialContext;
    }

    public void setInitialContext(List<StagingKeyValue> initialContext) {
        _initialContext = initialContext;
    }

    @Override
    @JsonProperty("mappings")
    public List<StagingMapping> getMappings() {
        return _mappings;
    }

    public void setMappings(List<StagingMapping> mapping) {
        _mappings = mapping;
    }

    @Override
    @JsonIgnore
    public Map<String, StagingSchemaInput> getInputMap() {
        return _parsedInputMap;
    }

    public void setInputMap(Map<String, StagingSchemaInput> parsedInputMap) {
        _parsedInputMap = parsedInputMap;
    }

    @JsonProperty("involved_tables")
    public Set<String> getInvolvedTables() {
        return _involvedTables;
    }

    @JsonDeserialize(as = LinkedHashSet.class)
    public void setInvolvedTables(Set<String> involvedTables) {
        _involvedTables = involvedTables;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        StagingSchema schema = (StagingSchema)o;

        // do not include _id, _lastModified and _parsedInputMap
        return Objects.equal(_displayId, schema._displayId) &&
                Objects.equal(_algorithm, schema._algorithm) &&
                Objects.equal(_version, schema._version) &&
                Objects.equal(_name, schema._name) &&
                Objects.equal(_title, schema._title) &&
                Objects.equal(_description, schema._description) &&
                Objects.equal(_subtitle, schema._subtitle) &&
                Objects.equal(_notes, schema._notes) &&
                Objects.equal(_schemaNum, schema._schemaNum) &&
                Objects.equal(_schemaSelectionTable, schema._schemaSelectionTable) &&
                Objects.equal(_schemaDiscriminators, schema._schemaDiscriminators) &&
                Objects.equal(_inputs, schema._inputs) &&
                Objects.equal(_initialContext, schema._initialContext) &&
                Objects.equal(_mappings, schema._mappings) &&
                Objects.equal(_involvedTables, schema._involvedTables);
    }

    @Override
    public int hashCode() {
        // do not include _id, _lastModified and _parsedInputMap
        return Objects.hashCode(_displayId, _algorithm, _version, _name, _title, _description, _subtitle, _notes, _schemaNum, _schemaSelectionTable,
                _schemaDiscriminators, _inputs, _initialContext, _mappings, _involvedTables);
    }
}
