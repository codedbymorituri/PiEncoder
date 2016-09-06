/*
PiEncoder - Written as part of my project for using FFmpeg to encode video and audio on my Raspberry Pi.
Copyright (C) 2016 morituri

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see http://www.gnu.org/licenses.
 */

package jPiEncoder;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Config {

    public static ArrayList<String> DragAndDropFilter;   
    public static ArrayList<String> EncodingDescriptions;
    public static ArrayList<String> EncodingProfiles;
    public static ArrayList<String> EncodingExtensions;
    private static final String AppPath = Config.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    public static String ConfigFile = AppPath.substring(0, AppPath.lastIndexOf('/')+1) + "/Config.xml";

    public static boolean ReadConfig() {
        if (GetDragAndDropFilter() == false) {
            return false;
        }
        if (GetEncodingProfiles() == false) {
            return false;
        }
        return true;
    }//End Sub

    private static boolean GetDragAndDropFilter() {
        DragAndDropFilter = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(ConfigFile);
            NodeList FilterList = doc.getElementsByTagName("DragAndDrop");
            for (int i = 0; i < FilterList.getLength(); i++) {
		Node xmlNode = FilterList.item(i);
		if (xmlNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element NodeText = (Element) xmlNode;
                    DragAndDropFilter.add(NodeText.getElementsByTagName("Filter").item(0).getTextContent());
		}
            }
        }
        catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }//End Sub    

    private static boolean GetEncodingProfiles() {
        EncodingDescriptions = new ArrayList<>();
        EncodingProfiles = new ArrayList<>();
        EncodingExtensions = new ArrayList<>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(ConfigFile);
            NodeList Profiles = doc.getElementsByTagName("EncodingProfile");
            for (int i = 0; i < Profiles.getLength(); i++) {
		Node xmlNode = Profiles.item(i);
		if (xmlNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element NodeText = (Element) xmlNode;
                    EncodingDescriptions.add(NodeText.getElementsByTagName("Description").item(0).getTextContent());
                    EncodingProfiles.add(NodeText.getElementsByTagName("Profile").item(0).getTextContent());
                    EncodingExtensions.add(NodeText.getElementsByTagName("Extension").item(0).getTextContent());
		}
            }
        }
        catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            return false;
        }
        return true;
    }//End Sub       
  
    public static void SaveConfig() {
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = dbFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();
            
            Element RootElement = doc.createElement("Config");
            doc.appendChild(RootElement);
            
            Element NodeDragAndDrop;
            Element NodeFilter;
            
            for (String NodeText : DragAndDropFilter) {
                NodeDragAndDrop = doc.createElement("DragAndDrop"); 
                RootElement.appendChild(NodeDragAndDrop);
                NodeFilter = doc.createElement("Filter"); 
                NodeFilter.appendChild(doc.createTextNode(NodeText));
                NodeDragAndDrop.appendChild(NodeFilter);
            }
            
            Element NodeEncodingProfile;
            Element NodeDescription;
            Element NodeProfile;
            Element NodeExtension;
            
            for (int Index = 0; Index < EncodingProfiles.size(); Index++) {
                NodeEncodingProfile = doc.createElement("EncodingProfile"); 
                RootElement.appendChild(NodeEncodingProfile);
                
                NodeDescription = doc.createElement("Description"); 
                NodeDescription.appendChild(doc.createTextNode(EncodingDescriptions.get(Index)));
                NodeEncodingProfile.appendChild(NodeDescription);
                
                NodeProfile = doc.createElement("Profile"); 
                NodeProfile.appendChild(doc.createTextNode(EncodingProfiles.get(Index)));
                NodeEncodingProfile.appendChild(NodeProfile);
               
                NodeExtension = doc.createElement("Extension"); 
                NodeExtension.appendChild(doc.createTextNode(EncodingExtensions.get(Index)));
                NodeEncodingProfile.appendChild(NodeExtension);
            }
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            
            try {
                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            }
            catch (Exception ex){
            }
            
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(ConfigFile);
            transformer.transform(source, result);
            JOptionPane.showConfirmDialog(null, "File saved ", "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }   
        catch (ParserConfigurationException pce) {
            //pce.printStackTrace();
        }
        catch (TransformerException tfe) {
            //tfe.printStackTrace();
	}
        catch (Exception ex) {
            JOptionPane.showConfirmDialog(null, ex.getMessage(), "PiEncoder", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
        }
    }
   
}//End Class
