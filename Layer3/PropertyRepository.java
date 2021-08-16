package com.example.demo.Layer3;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.Layer2.Property;
import com.example.demo.Layer3.Exceptions.PropertyNotFoundException;

@Repository
public interface PropertyRepository {
   public void insertProperty(Property property);
   public Property selectProperty(Long custId);
   public List<Property> selectAllProperty();
   public void deleteProperty(Long custId) throws PropertyNotFoundException;
}
