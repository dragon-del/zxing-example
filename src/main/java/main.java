import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.ITFWriter;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by duanerlong on 2015/07/15.
 */
public class main {
    public static void main(String args[]) {
        try {
//            String        contents = "12345678901231";
//            BarcodeFormat format   = BarcodeFormat.ITF;
//            int           width    = 200;
//            int           height   = 50;
//
//            ITFWriter writer = new ITFWriter();
//            BitMatrix bitMatrix = writer.encode(contents, format, width, height);

            String contents = "http://photo.oscasierra.net";
            BarcodeFormat format = BarcodeFormat.QR_CODE;
            int width = 160;
            int height = 160;

            Hashtable hints = new Hashtable();
            hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);

            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(contents, format, width, height, hints);

            BufferedImage image = MatrixToImageWriter.toBufferedImage(bitMatrix);
            ImageIO.write(image, "png", new File("barcode.png"));
        }
        catch( IOException e ) {
            e.printStackTrace();
        }
        catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
