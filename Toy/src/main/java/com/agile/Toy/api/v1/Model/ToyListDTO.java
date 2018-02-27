package com.agile.Toy.api.v1.Model;

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
