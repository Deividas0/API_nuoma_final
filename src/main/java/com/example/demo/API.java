package com.example.demo;

import com.mysql.cj.xdevapi.DbDoc;
import org.springframework.web.bind.annotation.*;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class API {
    private final NuomaService nuomaService = new NuomaService();
    private final KlientasService klientasService = new KlientasService();
    private final AutoService autoService = new AutoService();

    @GetMapping("/visiauto")
    public List<Auto> autoSarasas() throws SQLException {
        return autoService.autoSarasas();
    }

    @GetMapping("/autopagalid")
    public Auto autoPagalId(int id) throws SQLException {
        return autoService.autoPagalId(id);
    }

    @PostMapping("/naujasauto")
    public Auto naujasAuto(@RequestBody Auto auto) throws SQLException {
        autoService.naujasAuto(auto.getGamintojas(), auto.getModelis(), auto.getMetai(), auto.getUzimtumas());
        return null;
    }

    @PutMapping("/atnaujintiautoinfopagalid")
    public Auto keiciamAutoInfo(@RequestBody Auto auto, Optional<Integer> id) throws SQLException {
        autoService.keiciamAutoInfo(auto.getId(), auto.getGamintojas(), auto.getModelis(), auto.getMetai(), auto.getUzimtumas());
        return null;
    }

    @DeleteMapping("/pasalintiautopagalid")
    public void pasalintiAutoPagalId(int id) throws SQLException {
        autoService.pasalintiAutoPagalId(id);
    }

    @GetMapping("/gautivisusklientus")
    public List<Klientas> gautivisusklientus() throws SQLException {
        return klientasService.gautivisusklientus();
    }

    @GetMapping("/gautiklientapagalid")
    public Klientas gautiKlientaPagalId(int id) throws SQLException {
        return klientasService.gautiKlientaPagalId(id);
    }

    @PostMapping("/sukurtinaujaklienta")
    public Klientas sukurtiNaujaKlienta(@RequestBody Klientas k) throws SQLException {
        klientasService.sukurtiNaujaKlienta(k.getVardas(), k.getPavarde(), k.getEmail(), k.getTelNumeris());
        return null;
    }

    @PutMapping ("/atnaujintiklientoinfopagalid")
    private void atnaujintiKlientoInformacija(@RequestBody Klientas k) throws SQLException {
        klientasService.atnaujintiKlientoInformacija(k.getId(),k.getVardas(), k.getPavarde(), k.getEmail(), k.getTelNumeris());
    }
    @DeleteMapping("/istrintiklientapagalid")
    public void istrintiKlientaPagalId(int id) throws SQLException {
        klientasService.istrintiKlientaPagalId(id);
    }
    @GetMapping("/visasnuomossarasas")
    public List<Nuoma> visasNuomosSarasas() throws SQLException {
        return nuomaService.visasNuomosSarasas();
    }
    @PostMapping("/naujanuomosoperacija")
    public void sukurtiNaujaNuomosOperacija(@RequestBody Nuoma n) throws SQLException {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        Date sqlDate = Date.valueOf(localDate);
        nuomaService.sukurtiNaujaNuomosOperacija(n.getAutoId(), n.getKlientasId(), sqlDate);
    }
    @PutMapping("/pridetinuomaigrazinimodata")
    public void pridetiNuomaiGrazinimoData(@RequestBody Nuoma n) throws SQLException {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();
        Date sqlDate = Date.valueOf(localDate);
        nuomaService.pridetiNuomaiGrazinimoData(n.getId(),sqlDate);
    }
    @DeleteMapping("/istrintinuomapagalid")
        public void istrintiNuomaPagalId(int id) throws SQLException {
            nuomaService.istrintiNuomaPagalId(id);
        }

        // ------------------------------------  PAPILDOMI ENDPOINTAI -------------------------------

    @GetMapping("/visilaisviauto")
    public List<Auto> laisvuAutoSarasas() throws SQLException {
        return autoService.laisvuAutoSarasas();
    }

    @GetMapping("/visiautopagalgamintoja")
    public List<Auto> visiAutoPagalGamintoja(String gamintojas2) throws SQLException {
        return autoService.visiAutoPagalGamintoja(gamintojas2);
    }
    @GetMapping("/nuomapagalklientoid")
    public List<Nuoma> nuomaPagalKlientoId(int klientoId) throws SQLException {
        return nuomaService.nuomaPagalKlientoId(klientoId);
    }

    @GetMapping("/nuomadatosnuoiki")
    public List<Nuoma> nuomaPagalDatasNuoIki(String nuomosPradzia2, String nuomuosPabaiga2) throws SQLException {
        return nuomaService.nuomaPagalDatasNuoIki(nuomosPradzia2,nuomuosPabaiga2);
    }
    @GetMapping("/nuomaarauttolaisvaspagaldata")
        public boolean nuomaArAutoLaisvasPagalData(int autoId2, String data) throws SQLException {
        return nuomaService.nuomaArAutoLaisvasPagalData(autoId2,data);
    }
    @GetMapping("/gautivisusautopagalmetus")
    public List<Auto> gautiVisusAutoPagalMetus(int x) throws SQLException {
        return autoService.gautiVisusAutoPagalMetus(x);
    }

    @GetMapping("/klientaiturintysaktyvianuoma")
    public List<Klientas> klientaiTurintysAktyviaNuoma() throws SQLException {
        return klientasService.klientaiTurintysAktyviaNuoma();
    }

    @GetMapping("/isnomuotiautodaugiauneixkartu")
    public List<Auto> isnomuotiAutoDaugiauNeiXKartu(int x) throws SQLException {
        return autoService.isnomuotiAutoDaugiauNeiXKartu(x);
    }

}







