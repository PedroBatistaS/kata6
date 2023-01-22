package kata6;

import java.io.IOException;
import java.util.List;
import javax.xml.bind.JAXBException;
import model.Phonetic;

import model.Meaning;
import model.Meanings;
import model.Phonetics;
import model.control.XMLWriter;
import model.control.jsonReader;

public class Kata6 {
    
        public static void main(String[] args) throws IOException, JAXBException {
        String  url = "https://api.dictionaryapi.dev/api/v2/entries/en/football";
        List<Phonetic> phonetics = jsonReader.readJsonPhonetic(url);
        List<Meaning> meanings = jsonReader.readJsonMeaning(url);
        Phonetics phoneticsWrapper = new Phonetics(phonetics);
        Meanings meaningsWrapper = new Meanings(meanings);
        String xml = XMLWriter.toXML(phoneticsWrapper, meaningsWrapper);
        XMLWriter.writeXML(xml, "kata6.xml");
}

