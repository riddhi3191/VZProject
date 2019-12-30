package com.riddhi.cloud.itemservice.Service;


import com.riddhi.cloud.itemservice.Model.Item;
import com.riddhi.cloud.itemservice.Repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> getAllItems () {
        return itemRepository.findAll();
    }

    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    public Item getItemByName(String name) {
        Optional<Item> itemWithName = itemRepository.findByName(name);
        if (itemWithName.isPresent()) {
            return itemWithName.get();
        }
        return null;
    }

    public List<Item> findByNamesList(List<String> itemNames){

        List<Item> foundItems = new ArrayList<>();

        for(int i=0 ; i<itemNames.size() ; i++) {
            Optional<Item> checkItem = itemRepository.findByName(itemNames.get(i));
            if(checkItem.isPresent()){
                foundItems.add(checkItem.get());
            }
            else {
                System.out.println("this item was not found by the name: " + itemNames.get(i));
            }
        }

        return  foundItems;
    }

}
