package com.dataScienceProjects.healthCareAnalyzer.service;

import com.dataScienceProjects.healthCareAnalyzer.dto.ArrayOfObjects;
import com.dataScienceProjects.healthCareAnalyzer.entity.PatientEntity;
import com.dataScienceProjects.healthCareAnalyzer.repository.PatientsRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.univocity.parsers.common.record.Record;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Service
public class AnalyticsService {
    @Autowired
    ObjectMapper mapper;
    @Autowired
    PatientsRepository patientsRepository;
    public ArrayOfObjects getAnalyticsData(String columnName) {


        if(columnName.equals("age")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[][] arr = {{21,30},{31,40},{41,50},{51,60},{61,70},{71,80}};
            for(int[] ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByAgeBetween(ele[0],ele[1]).size();
                objectNode.put("name",String.format("%d - %d",ele[0],ele[1]));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);

        }

        if(columnName.equals("ca")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[] arr = {0,1,2,3,4};
            for(int ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByCa(ele).size();
                objectNode.put("name",String.format("%d",ele));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);
        }

        if(columnName.equals("chol")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[][] arr = {{0,100},{101,200},{201,300},{301,400},{401,500},{501,600}};
            for(int[] ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByCholBetween(ele[0],ele[1]).size();
                objectNode.put("name",String.format("%d - %d",ele[0],ele[1]));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);

        }

        if(columnName.equals("cp")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[] arr = {0,1,2,3};
            for(int ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByCp(ele).size();
                objectNode.put("name",String.format("%d",ele));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);
        }

        if(columnName.equals("exang")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[] arr = {0,1};
            for(int ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByExang(ele).size();
                objectNode.put("name",String.format("%d",ele));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);
        }

        if(columnName.equals("fbs")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[] arr = {0,1};
            for(int ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByFbs(ele).size();
                objectNode.put("name",String.format("%d",ele));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);
        }


        //Duplicate values might occur for upper and lower bounds
        if(columnName.equals("oldpeak")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[][] arr = {{0,1},{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
            for(int[] ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByOldpeakBetween(ele[0],ele[1]).size();
                objectNode.put("name",String.format("%d - %d",ele[0],ele[1]));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);

        }

        if(columnName.equals("restecg")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[] arr = {0,1,2};
            for(int ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByRestecg(ele).size();
                objectNode.put("name",String.format("%d",ele));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);
        }

        if(columnName.equals("sex")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[] arr = {0,1};
            for(int ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findBySex(ele).size();
                objectNode.put("name",String.format("%d",ele));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);
        }

        if(columnName.equals("slope")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[] arr = {0,1,2};
            for(int ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findBySlope(ele).size();
                objectNode.put("name",String.format("%d",ele));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);
        }


        //Duplicate values might occur for upper and lower bounds
        if(columnName.equals("target")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            double[][] arr = {{0,0.1},{0.1,0.2},{0.2,0.3},{0.3,0.4},{0.4,0.5},{0.5,0.6},{0.6,0.7},{0.7,0.8},{0.8,0.9},{0.9,1.0}};
            for(double[] ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByTargetBetween(ele[0],ele[1]).size();
                objectNode.put("name",String.format("%f - %f",ele[0],ele[1]));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);

        }

        if(columnName.equals("thal")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[] arr = {0,1,2,3};
            for(int ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByThal(ele).size();
                objectNode.put("name",String.format("%d",ele));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);
        }

        if(columnName.equals("thalach")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[][] arr = {{70,80},{81,90},{91,100},{101,110},{111,120},{121,130},{131,140},{141,150},{151,160},{161,170},{171,180},{181,190},{191,200},{201,210}};
            for(int[] ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByThalachBetween(ele[0],ele[1]).size();
                objectNode.put("name",String.format("%d - %d",ele[0],ele[1]));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);

        }

        if(columnName.equals("trestbps")) {

            ArrayList<ObjectNode> arrayList = new ArrayList<>();
            int[][] arr = {{91,100},{101,110},{111,120},{121,130},{131,140},{141,150},{151,160},{161,170},{171,180},{181,190},{191,200}};
            for(int[] ele: arr){
                ObjectNode objectNode = mapper.createObjectNode();
                int count = patientsRepository.findByTrestbpsBetween(ele[0],ele[1]).size();
                objectNode.put("name",String.format("%d - %d",ele[0],ele[1]));
                objectNode.put("value",count);
                arrayList.add(objectNode);
            }
            return new ArrayOfObjects(arrayList);

        }

        

        throw new UsernameNotFoundException("Not Found");





    }


    public List<PatientEntity> getAllPatients() {
        return patientsRepository.findByOrderByIdAsc();

    }

    public String uploadCsv(MultipartFile file) throws IOException {
        List<PatientEntity> patientEntities = new ArrayList<>();
        InputStream inputStream = file.getInputStream();
        CsvParserSettings settings = new CsvParserSettings();
        settings.setHeaderExtractionEnabled(true);
        CsvParser parser = new CsvParser(settings);

        List<Record> parseAllRecords = parser.parseAllRecords(inputStream);
        parseAllRecords.forEach(record -> {
            PatientEntity patient = new PatientEntity();
            patient.setAge(Integer.parseInt(record.getString("age")));
            patient.setCa(Integer.parseInt(record.getString("ca")));
            patient.setChol(Integer.parseInt(record.getString("chol")));
            patient.setCp(Integer.parseInt(record.getString("cp")));
            patient.setEmail(record.getString("email"));
            patient.setExang(Integer.parseInt(record.getString("exang")));
            patient.setFbs(Integer.parseInt(record.getString("fbs")));
            patient.setFirstName(record.getString("first_name"));
            patient.setLastName(record.getString("last_name"));
            patient.setOldpeak(Double.parseDouble(record.getString("oldpeak")));
            patient.setRestecg(Integer.parseInt(record.getString("restecg")));
            patient.setSex(Integer.parseInt(record.getString("sex")));
            patient.setSlope(Integer.parseInt(record.getString("slope")));
            patient.setTarget(Double.parseDouble(record.getString("target")));
            patient.setThal(Integer.parseInt(record.getString("thal")));
            patient.setThalach(Integer.parseInt(record.getString("thalach")));
            patient.setTrestbps(Integer.parseInt(record.getString("trestbps")));
            patientEntities.add(patient);
        });

        patientsRepository.deleteAll();
        patientsRepository.saveAll(patientEntities);

        return "Saved Successfully";

    }
}
