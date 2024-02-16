package com.dataScienceProjects.healthCareAnalyzer.dto;

import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArrayOfObjects {
    ArrayList<ObjectNode> array;


}
