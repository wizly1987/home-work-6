package com.goit.gojavaonline;

import java.util.*;

abstract class MusicInstuments {
    public abstract String getType();

@Override
    public  String toString () {
    return "MusicInstuments{" + getType() + "}";
}

  class Guitar extends MusicInstuments{
      @Override
          public String getType() {
                  return "guitar";
              }
  }

 class Piano extends MusicInstuments{

    @Override
    public String getType() {
        return "piano";
    }
}


    class Trumpet extends MusicInstuments{

        @Override
        public String getType() {
            return "trumpet";
        }
    }

    class MusicShop{
        List<MusicInstuments> musicInstumentses;
        public List<MusicInstuments> getMusicInstumentses(){
         return musicInstumentses;
        }

        public void setMusicInstuments(ArrayList<MusicInstuments> musicInstuments) {
            this.musicInstuments = musicInstuments;
        }
    }

    public void setMusicalInstuments(List<MusicInstuments> musicalInstumentses){
        this.musicalInstumentses=musicalInstumentses;

    }
    @Override
    public String toString(){
        return "MusicShop{"+"MusicInstuments="+ musicalInstumentses +'}' ;
    }

    public class Main {

        public static void main(String[] args) {
            MusicShop shop = new MusicShop();


            ArrayList<MusicInstuments> musicInstuments = new ArrayList<>();
            for (int i = 0; i < 5; i++) {
                musicInstuments.add(new Guitar());
            }
            for (int i = 0; i < 4; i++) {
                musicInstuments.add(new Piano());
            }
            shop.setMusicInstuments(musicInstuments);


            Map<String, Integer> order = new HashMap<>();
            order.put("Guitar", 2);
            order.put("Piano", 3);


            System.out.println(shop);

            try {
                List<MusicInstuments> musicInstrumentsToBeRemoved = prepareListOfMusicInstumentsToRemove(shop, order);
                removeMusicInstrumentsFromTheShop(shop, order);
                System.out.println("Order: " + musicInstrumentsToBeRemoved);
            } catch (Exception e) {
                System.out.println("Exception happened: " + e.getMessage());
            }
            System.out.println(shop);

        }

        private static List<MusicInstuments> prepareListOfMusicInstumentsToRemove(MusicShop musicShop , Map<String, Integer> order ) {
            List<MusicShop> result = new ArrayList<>();

            for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
                String musicInstumentsTypeType = orderEntry.getKey();
                Integer numberOfMusicInstumentToBeRemoved = orderEntry.getValue();
                int numberOfMusicInstumentsRemoved = 0;
                for (MusicInstuments musicInstuments : MusicShop.getMusicInstumentses()) {
                    if (musicInstuments.getType().equals(musicInstumentsType) && numberOfMusicInstumentsRemoved < numberOfMusicInstumentToBeRemoved) {
                        result.add(musicInstuments);
                        numberOfMusicInstumentsRemoved++;
                    }
                }
                if (numberOfMusicInstumentsRemoved < numberOfMusicInstumentToBeRemoved)
                    throw new IllegalArgumentException("Shop does not have enough " + musicInstumentsType + "s");
            }

            return result;
        }

        private static void removeMusicInstrumentsFromTheShop(MusicShop musicShop, Map<String, Integer> order){
            for (Map.Entry<String, Integer> orderEntry : order.entrySet()) {
                String musicInstrumentsType = orderEntry.getKey();
                Integer numberOfAnimalToBeRemoved = orderEntry.getValue();
                int numberOfAnimalsRemoved = 0;
                Iterator<MusicInstuments> iterator = musicShop.getMusicInstumentses().iterator();
                while (iterator.hasNext()) {
                    MusicInstuments musicInstuments = iterator.next();
                    if (musicInstruments.getType().equals(musicInstrumentsType) && numberOfMusicInstrumentsRemoved<numberOfMusicInstrumentsToBeRemoved) {
                        iterator.remove();
                        numberOfMusicInstrumentsRemoved++;


                    }
                }
            }



    }
    }


}
