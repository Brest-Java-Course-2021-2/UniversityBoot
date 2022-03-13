package com.epam.brest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public interface GroupeJpaRepository extends JpaRepository <Group, Integer> {

    default List<String> getAllGroupesByName (){
        return (List<String>) findAll().stream()
                .flatMap(groupes -> Stream.of(groupes.getGroupName()))
                .collect(Collectors.toList());
    }

    default List <Group> getAllGroupes(){
          return (List<Group>) findAll();
      }


    default String deleteGroupeByName(String nameGroupe){
          Optional<Group> groupe = (Optional<Group>) findAll().stream()
                    .filter(gr -> nameGroupe.equalsIgnoreCase(gr.getGroupName()))
                    .collect(Collectors.toList())
                    .stream()
                    .findFirst();
        if (groupe.isPresent()){
            delete(groupe.get());
            return (String) groupe.get().getGroupName();
        } else {
         return "Is Empty";
        }
      }



    default Group insertNewGroupe(String nameGroupe){
          Group groupe = (Group) save(new Group(nameGroupe));
          return (Group) groupe;
      }

    default Group getGroupeByName(String name){
        List<Group> groupes = (List<Group>) getAllGroupes();
        int  index= (int) groupes.stream()
                                    .filter(gr -> name.equals(gr.getGroupName()))
                                    .collect(Collectors.toList()).stream().count();
          if (index > 0) {
              return groupes.get(index-1);
          } else {
              return new Group();
          }

     }


    default Group updateGroupeByName(String newName, String oldName){
          Group groupe = (Group) getGroupeByName(oldName);
          groupe.setGroupName(newName);
          return (Group) save(groupe);
      }
}
