package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.ArrayList;
import java.util.List;

public class FavoriteNeighbourIdList {

    List<Long> neighbourFavoriteList;

    public FavoriteNeighbourIdList() {
        neighbourFavoriteList = new ArrayList<Long>();
    }

    public List<Long> getlist() {
        return neighbourFavoriteList;
    }

    public void addIdNeighbour(Long neighbourId) {
        neighbourFavoriteList.add(neighbourId);
    }

    public void deleteIdNeighbour(Long neighbourId) {
        neighbourFavoriteList.remove(neighbourId);
    }

    public int countNeighbour() {
        return neighbourFavoriteList.size();
    }

    public Neighbour getFavoriteNeighboursFromList(Long neighbourId, List<Neighbour> listeNeighbour) {
        int listeNeighbourSize = listeNeighbour.size();
        for (int i = 0; i < listeNeighbourSize; i++) {
            if (listeNeighbour.get(i).getId() == neighbourId) {
                return listeNeighbour.get(i);
            }
        }
        return null;
    }

    public List<Neighbour> getFavoriteNeighboursListFromNeighboursApi(NeighbourApiService neighbourApiService) {
        List<Neighbour> neighboursObjetList = new ArrayList<Neighbour>();
        for (int i = 0; i < this.countNeighbour(); i++) {
            Neighbour addNeighbour = getFavoriteNeighboursFromList(this.getlist().get(i), neighbourApiService.getNeighbours());
            neighboursObjetList.add(addNeighbour);
        }
        return neighboursObjetList;
    }
}
