import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;


/*
 * (@)# PropertyManager.java
 * 
 * 2006. 4. 26
 *
 * ====================================================================
 *
 * WarePlus., Software License, Version 1.0
 *
 * Copyright (c) 2002-2004 Ware Plus.,
 * WarePlus  * All rights reserved.
 *
 * DON'T COPY OR REDISTRIBUTE THIS SOURCE CODE WITHOUT PERMISSION.
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL WarePlus OR ITS
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * For more information on this product, please see 
 * WarePlus	
 *
 */

/**
 * @author Sejin
 * 
 */
public class PropertyManager {
    private Properties property;
    private String fileName;
    
    public PropertyManager(){ }
    
    /**
     * 생성시 파일을 로드한다. 
     * @param fileName
     */
    public PropertyManager(String fileName){
        setLoad( fileName );
    }
    
    /**
     * 파라미터로 받은 파일명을 프로퍼티 파일로 로드 시킨다.
     * @param fileName
     */
    public void setLoad( String fileName ){
        this.fileName = fileName;
        
        try {
            property = new Properties();
            property.load(new FileInputStream( fileName ));
        } catch (FileNotFoundException e2) {
            System.out.println("Property File이 존재 하지 않습니다.");
        } catch (IOException e2) {
            System.out.println("환경 변수를 처리할 수 없습니다.");
        }
    }
    
    /**
     * 키에 해당하는 값을 넘겨준다
     * @param key
     * @return
     */
    public String getProperty( String key ){
        return property.getProperty( key );
    }
    
    /**
     * 키에 해당하는 이전의 값을 넘겨 받은 값으로 변경한다   
     * @param key
     * @param value
     */
    public void setProperty( String key, String value ){
        property.setProperty(key, value);
        store();
    }
    
    public void store(){
        try {
            property.store(new FileOutputStream(fileName), null);
        } catch(IOException e) {
            System.out.println("파일저장중 오류가 발생하였습니다");
        }
    }
}
