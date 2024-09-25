package com.DoctorAppointment.util;

import com.DoctorAppointment.Booking.Entity.Booking;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;

@Component
public class PdfService {

    public byte[] generatePdf(Booking bookingDetails) {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, baos);
            document.open();

            // Add content to the PDF
            addContentToPdf(document, bookingDetails);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return baos.toByteArray();
    }

    private void addContentToPdf(Document document, Booking bookingDetails) throws DocumentException {
        document.add(new Paragraph("Appointment ID: " + bookingDetails.getBookingId()));
        document.add(new Paragraph("Name: " + bookingDetails.getFirstName()+" "+bookingDetails.getLastName()));
        document.add(new Paragraph("Doctor Name: " + bookingDetails.getDoctor().getName()));
            document.add(new Paragraph("Doctor Fees: " + bookingDetails.getDoctor().getFees()));
        document.add(new Paragraph("City: " + bookingDetails.getCity()));

        document.add(new Paragraph("Appointment Date: " + bookingDetails.getDate().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
        document.add(new Paragraph("Appointment Slot: " + bookingDetails.getSlots().getStartTime()+" - "+bookingDetails.getSlots().getEndTime()));
        document.add(new Paragraph("Email: " + bookingDetails.getEmail()));
        document.add(new Paragraph("Mobile Number: " + bookingDetails.getMobileNumber()));

    }
}