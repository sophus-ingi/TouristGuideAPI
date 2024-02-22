package com.example.TouristGuideAPI.repository;

import com.example.TouristGuideAPI.model.TouristAttraction;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TouristRepository {
    private List<TouristAttraction> touristAttractions;

    public TouristRepository() {
        touristAttractions = new ArrayList<>();
        touristAttractions.add(new TouristAttraction("Zoo", "The Zoo in Copenhagen is one of the oldest culture institutions in Denmark. The origin of the Zoo dates all the way back to 1859 where it was one of the first zoo's in all of Europe! Today the Zoo is one of the most attractive places for a fun and educational day with either family, friends or even alone. The Zoo has around 1.3 million guests every year, and with more than 4000 different animals and 250 different sorts of animals, it is impossible not to have fun when visiting", "København", List.of("Underholdning", "Familie", "Restaurant")));
        touristAttractions.add(new TouristAttraction("Tivoli", "A very popular Amusement park", "København", List.of("Underholdning", "Restaurant", "Koncert")));
    }

    public List<TouristAttraction> getTouristAttractions() {
        return touristAttractions;
    }

    public void addTouristAttraction(TouristAttraction touristAttraction) {
        touristAttractions.add(touristAttraction);

    }

    public TouristAttraction getAttractionByName(String name) {
        int i = 0;
        while (i < touristAttractions.size()) {
            if (name.equals(touristAttractions.get(i).getName())) {
                return touristAttractions.get(i);
            }
            i++;
        }
        return null;
    }


    public void updateTouristAttraction(TouristAttraction updatedAttraction) {

        for (TouristAttraction touristAttraction : touristAttractions) {
            if (touristAttraction.getName().equals(updatedAttraction.getName())) {
                touristAttraction.setDescription(updatedAttraction.getDescription());
                touristAttraction.setTags(updatedAttraction.getTags());
                touristAttraction.setCity(updatedAttraction.getCity());
            }


        }

    }

    public void deleteAttraction(String name) {
        int i =0;
        TouristAttraction Attraction;
        while (i<touristAttractions.size()) {
            if (name.equals(touristAttractions.get(i).getName())) {
                Attraction = touristAttractions.get(i);
                touristAttractions.remove(Attraction);


            }
            i++;
        }
    }

    public List<String> getTagsForAttraction(String name) {
        TouristAttraction attraction = getAttractionByName(name);
        if (attraction != null) {
            return attraction.getTags();
        } else
            return null;

    }

    public List<String> getCities() {
        return List.of("Copenhagen", "Aarhus", "Odense", "Aalborg");
    }

    public List<String> getTags() {
        return List.of("Underholdning", "Familie", "Restaurant", "Koncert", "Gratis", "Kunst", "Museum", "Natur");

    }
}