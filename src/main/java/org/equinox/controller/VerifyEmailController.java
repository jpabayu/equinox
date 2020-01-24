package org.equinox.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class VerifyEmailController {

	@Autowired
	private ContextLoader contextLoader;
	private Logger logger = Logger.getLogger(VerifyEmailController.class);

	@RequestMapping(value = "/confirmEmail", method = RequestMethod.GET)
	public String confirmEmail(@RequestParam(value = "ticketID", required = false) String ticketID, Model model) {
		if (ticketID == null) {
			return "page_404";
		}
		HttpURLConnection conn = null;
		BufferedReader br = null;
		try {
			URL url = new URL(contextLoader.getHostURL() + "?ticketID=" + URLEncoder.encode(ticketID, "UTF-8"));
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

			int responceCode = conn.getResponseCode();
			if (responceCode == 200) {
				br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			} else {
				br = new BufferedReader(new InputStreamReader((conn.getErrorStream())));
			}

			StringBuilder sb = new StringBuilder();
			String output;
			while ((output = br.readLine()) != null) {
				sb.append(output + "\n");
			}
			br.close();

			logger.info("Verify Email ========> " + sb.toString());
			JSONObject obj = new JSONObject(sb.toString());
			JSONObject stat = obj.getJSONObject("status");
			if (stat.getString("message").equalsIgnoreCase("PROCESSED")) {
				model.addAttribute("status", stat.getString("message"));
				return "confirmEmailSuccess";
			} else {
				model.addAttribute("status", stat.getString("message"));
				return "confirmEmailFailed";
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return "page_500";
		} catch (IOException exx) {
			exx.printStackTrace();
			return "page_500";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "page_500";
		} finally {
			conn.disconnect();
		}
	}
}
