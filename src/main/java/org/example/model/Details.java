package org.example.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Set;
@Data
public class Details implements Serializable {
    private Copias copias;

    public Details(Copias copias) {
        this.copias = copias;
    }
}
