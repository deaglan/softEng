package ex1;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
/**
 * @author Deaglan
 * This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
public class GiftFile {
	String giftStringTrueFalse;
	String giftStringMCQ;
	String giftStringMatch;
	String giftEssay;
	String giftMath;
	
	File giftFile;
	public GiftFile (File giftFileMain) {
		giftFile = giftFileMain;
	}
	public void createTrueFalseQuestion (String questionTitle, String questionText, String questionAnswer){
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(giftFile, true));
			
			giftStringTrueFalse = String.format("::%s:: %s {%s}%n", questionTitle, questionText, questionAnswer);
			//giftStringMCQ = String.format("::%s:: %s {%s}%n", questionTitle, questionText, questionAnswer);
			bufWrite.write(giftStringTrueFalse);
			//bufWrite.write(giftStringMCQ);
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createMCQuestion (String questionTitle, String questionText, String questionAnswer, String questionAnswer2, String questionAnswer3, String questionAnswer4){
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(giftFile, true));
			
			//giftStringTrueFalse = String.format("::%s:: %s {%s}%n", questionTitle, questionText, questionAnswer);
			giftStringMCQ = String.format("::%s::%s{=%s ~%s ~%s ~%s}%n", questionTitle, questionText, questionAnswer, questionAnswer2, questionAnswer3, questionAnswer4);
			
			//bufWrite.write(giftStringTrueFalse);
			bufWrite.write(giftStringMCQ);
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createMatchQuestion (String questionTitle, String questionText, String questionAnswer, String questionText2, String questionAnswer2, String questionText3, String questionAnswer3){
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(giftFile, true));
			
			//giftStringTrueFalse = String.format("::%s:: %s {%s}%n", questionTitle, questionText, questionAnswer);
			giftStringMatch = String.format("::%s::{=%s->%s =%s->%s =%s->%s}%n", questionTitle, questionText, questionAnswer, questionText2, questionAnswer2,  questionText3, questionAnswer3);
			
			//bufWrite.write(giftStringTrueFalse);
			bufWrite.write(giftStringMatch);
			bufWrite.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createEssayQuestion (String questionTitle, String questionText, String questionAnswer){
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(giftFile, true));
			
			giftEssay = String.format("::%s:: %s {%s}%n", questionTitle, questionText, questionAnswer);
			bufWrite.write(giftEssay);
			bufWrite.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public void createMathsQuestion (String questionTitle, String questionText, String questionAnswer, String tolerence, String credit ){
		try {
			BufferedWriter bufWrite = new BufferedWriter(new FileWriter(giftFile, true));
			
			giftMath = String.format("::%s:: %s {#%s:%s # Correct}%n", questionTitle, questionText, questionAnswer, tolerence, credit);
			bufWrite.write(giftMath);
			bufWrite.close();
			
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
