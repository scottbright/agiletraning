package com.agile.toy.api.v1.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ToyListDTO {

    @JsonProperty("ToyLists")
    private List<ToyListItemDTO> toyListDTOList;

    public ToyListDTO(List<ToyListItemDTO> toyListDTOList){
        this.toyListDTOList = toyListDTOList;
    }

    public List<ToyListItemDTO> getToyListDTOList() {
        return toyListDTOList;
    }

    public void setToyListDTOList(List<ToyListItemDTO> toyListDTOList) {
        this.toyListDTOList = toyListDTOList;
    }
}
