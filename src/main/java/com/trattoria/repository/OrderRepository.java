package com.trattoria.repository;

import com.trattoria.domain.Order;
import com.trattoria.domain.User;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class OrderRepository {

    File savedOrderMap = new File("orderMap.save");
    Map<User, Order> orderMap = new HashMap<>();

    public void saveOrderToFile(User user, Order order) {

        orderMap.put(user, order);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(savedOrderMap));
            oos.writeObject(orderMap);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readOrderFromFile() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(savedOrderMap));
            Object readObject = ois.readObject();
            if (readObject instanceof HashMap) {
                orderMap.putAll((HashMap) readObject);
            }
            ois.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        for(Map.Entry<User, Order> entry: orderMap.entrySet()) {
            System.out.println("user: " + entry.getKey().getName());
            entry.getValue().printOrder();

        }
    }
}
