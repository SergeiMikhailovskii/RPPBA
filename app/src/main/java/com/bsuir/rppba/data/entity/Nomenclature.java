package com.bsuir.rppba.data.entity;

import com.google.gson.annotations.SerializedName;

public class Nomenclature {

    private int id;
    private String name;

    @SerializedName("nomenclature_type")
    private String nomenclatureType;

    @SerializedName("kind_of_nomenclature")
    private String kindOfNomenclature;

    public Nomenclature(int id, String name, String nomenclatureType, String kindOfNomenclature) {
        this.id = id;
        this.name = name;
        this.nomenclatureType = nomenclatureType;
        this.kindOfNomenclature = kindOfNomenclature;
    }

    public Nomenclature() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNomenclatureType() {
        return nomenclatureType;
    }

    public void setNomenclatureType(String nomenclatureType) {
        this.nomenclatureType = nomenclatureType;
    }

    public String getKindOfNomenclature() {
        return kindOfNomenclature;
    }

    public void setKindOfNomenclature(String kindOfNomenclature) {
        this.kindOfNomenclature = kindOfNomenclature;
    }

}
