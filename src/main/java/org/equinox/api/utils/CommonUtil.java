package org.equinox.api.utils;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.commons.lang.StringUtils;
import org.equinox.api.config.Configuration;
import org.equinox.api.config.Key;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.regex.Pattern;

public final class CommonUtil {
	
	private static final ObjectMapper objectMapper = new ObjectMapper();
	
	private static String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
			"[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
	
	public static String standardizedUsername(String username) {
        String result = username;
        
        if(result.length() < 4) return "0";
        
        if(result.startsWith("+")) {
            result = result.replace("+", "");
        }

        if(result.startsWith("62")) {
            result = result.substring(2);

            if(!result.startsWith("8")) {
                //invalid phone number
                return "0";
            } else {
                return "0" + result;
            }
        }
        
        if(!result.startsWith("08")) {
            //invalid phone number
            return "0";
        }

        return result;
    }
    
    public static String standardizedMSISDN(String phone) {
        String result = phone;

        if(result.length() < 4) return result;

        if(result.startsWith("+")) {
            result = result.replace("+", "");
        }

        if(result.startsWith("62")) {
            if(result.charAt(2) != '8') {
                //invalid phone number
                return "0";
            } else {
                return result;
            }
        }
        
        if(result.startsWith("08")) {
            return "62" + result.substring(1);
        }
        
        return "0";
    }
	
	/**
	 * Check if the phone number is valid.
	 * Valid phone number has length between 9 to 15 (including 0) and contain only number.
	 * 
	 * @param phoneNumber
	 * @return true if the phone number is valid, false otherwise
	 */
	public static boolean isValidPhoneNumber(String phoneNumber) {
		int length = phoneNumber.length();
        if(length > 8 && length < 16) {
            if(StringUtils.isNumeric(phoneNumber)){
                return true;
            }
        }
        
        return false;
	}
	
	public static boolean isValidEmail(String email) {       
        Pattern pattern = Pattern.compile(emailRegex);
        if (email == null)
            return false;
        return pattern.matcher(email).matches();
    }
	
	public static String removeWhiteSpace(String data) {
		if(data == null) return null;
		
		return data.replaceAll("\\s+","");
	}
	
	public static String removeNewLine(String data) {
		if(data == null) return null;
		
		return data.replaceAll("\n+","");
	}
	
	public static String hideCredential(String data) {
		if(data == null) return null;
		
		String result = data;
		
		String credentialField = "\"credential\"";
		if(result.contains(credentialField)) {
			int credentialFieldIdx = result.indexOf(credentialField);
			int colonIdx = result.indexOf(":", credentialFieldIdx);
			int startIdx = result.indexOf("\"", colonIdx) + 1;
			int endIdx = result.indexOf("\"", startIdx);
			result = result.substring(0,startIdx) + "***" + result.substring(endIdx);
		}
		
		String oldCredentialField = "\"oldCredential\"";
		if(result.contains(oldCredentialField)) {
			int credentialFieldIdx = result.indexOf(oldCredentialField);
			int colonIdx = result.indexOf(":", credentialFieldIdx);
			int startIdx = result.indexOf("\"", colonIdx) + 1;
			int endIdx = result.indexOf("\"", startIdx);
			result = result.substring(0,startIdx) + "***" + result.substring(endIdx);
		}
		
		String newCredentialField = "\"newCredential\"";
		if(result.contains(newCredentialField)) {
			int credentialFieldIdx = result.indexOf(newCredentialField);
			int colonIdx = result.indexOf(":", credentialFieldIdx);
			int startIdx = result.indexOf("\"", colonIdx) + 1;
			int endIdx = result.indexOf("\"", startIdx);
			result = result.substring(0,startIdx) + "***" + result.substring(endIdx);
		}
		
		return result;
	}
	
	public static String hideCredentialXML(String data) {
		if(data == null) return null;

        String result = data;

        String credentialField = "<credential>";
        if(result.contains(credentialField)) {
            int credentialFieldIdx = result.indexOf(credentialField);
            int rightArrowIdx = result.indexOf(">", credentialFieldIdx);
            int startIdx = rightArrowIdx + 1;
            int endIdx = result.indexOf("</", startIdx);
            result = result.substring(0,startIdx) + "***" + result.substring(endIdx);
        }

        return result;
	}
	
	public static String getRandomNumberInRange(String max) {
		Random r = new Random();
		Long lrand = r.longs(1, (Long.valueOf(max) + 1)).limit(1).findFirst().getAsLong();
		String rand = String.valueOf(lrand);
		int size = max.length();
		String pad;
		if (rand.length() == 1) {
			pad = StringUtils.rightPad(rand, size, '0');
		} else {
			pad = StringUtils.leftPad(rand, size, '0');
		}
		return pad;
	}
	
	public static String getFileName(String path) {
		String result = path;
		if(result.contains("/")) {
			int lastIdx = result.lastIndexOf("/");
			if(lastIdx < result.length()-1) {
				result = result.substring(lastIdx+1);
			} else {
				result = "";
			}
		}
		
		if(!result.contains(".")) {
			result = "";
		}
		
		return result;
	}
	
	public static StringBuilder removePrefix(StringBuilder sb, char prefix) {
		if(sb.length() > 0 && sb.charAt(0) == prefix) {
			
			int startIdx = 0;
			int endIdx = 1;
			for(int i=1; i<sb.length(); i++) {
				if(sb.charAt(i) == prefix) {
					endIdx++;
				} else {
					break;
				}
			}
			
			sb.delete(startIdx, endIdx);
		}
		
		return sb;
	}
	
	public static String removePrefix(String data, char prefix) {
		if(data.length() > 0 && data.charAt(0) == prefix) {
			
			int startIdx = 1;
			for(int i=1; i<data.length(); i++) {
				if(data.charAt(i) == prefix) {
					startIdx++;
				} else {
					break;
				}
			}
			
			return data.substring(startIdx);
		}
		
		return data;
	}
	
	public static StringBuilder removeSuffix(StringBuilder sb, char suffix) {
		int length = sb.length();
		if(length > 0 && sb.charAt(length-1) == suffix) {
			
			int startIdx = length-1;
			int endIdx = length;
			for(int i=length-2; i>=0; i--) {
				if(sb.charAt(i) == suffix) {
					startIdx--;
				} else {
					break;
				}
			}
			
			sb.delete(startIdx, endIdx);
		}
		
		return sb;
		
	}
	
	public static String removeSuffix(String data, char suffix) {
		int length = data.length();
		if(length > 0 && data.charAt(length-1) == suffix) {
			
			int startIdx = 0;
			int endIdx = length-1;
			for(int i=length-2; i>=0; i--) {
				if(data.charAt(i) == suffix) {
					endIdx--;
				} else {
					break;
				}
			}
			
			return data.substring(startIdx, endIdx);
		}
		
		return data;
	}
	
	public static String padZeroDecimal(double data, int numberOfDecimal) {
        StringBuilder sb = new StringBuilder(Double.toString(data));

        int dotIdx = sb.lastIndexOf(".");
        if(numberOfDecimal < 1) {
            if(dotIdx == -1) {
                return sb.toString();
            } else {
            	return sb.substring(0, dotIdx);
            }
        } else {
            if(dotIdx == -1) {
                sb.append(".");
                for(int i=0; i<numberOfDecimal; i++) {
                    sb.append("0");
                }

                return sb.toString();
            } else {
                int currentTotalDecimal = sb.length() - (dotIdx + 1);
                if(currentTotalDecimal < numberOfDecimal) {
                    while(currentTotalDecimal < numberOfDecimal) {
                        sb.append("0");
                        currentTotalDecimal++;
                    }
                } else {
                    while(currentTotalDecimal > numberOfDecimal) {
                        sb.deleteCharAt(sb.length()-1);
                        currentTotalDecimal--;
                    }
                }

                return sb.toString();
            }
        }
    }
	
	public static String replace(String str, String pattern, String[] replacements) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        
        int startIdx = 0;
        
        for(String arg : replacements) {
            int idx = sb.indexOf(pattern, startIdx);
            
            if(idx == -1) break;
            
            int endIdx = idx+pattern.length();
            sb.replace(idx, endIdx, arg);
            startIdx = endIdx;
        }
        
        return sb.toString();
    }
	
	public static String objectToJson(Object o) throws Exception {
		return objectMapper.writeValueAsString(o);
	}
	
	//input must contain numbers only
	public static int calculateCheckDigit(String input) {
        String digits = input+"0";
        boolean isSecond = false;
                
        int[] arrDigit = new int[digits.length()];
        int total = 0;
        for(int i=arrDigit.length-1; i>=0; i--) {
            arrDigit[i] = Integer.parseInt(String.valueOf(digits.charAt(i)));
            
            if(isSecond) {
                //multiply by 2
                int doubled = arrDigit[i] << 1;
                if(doubled > 9) {
                    arrDigit[i] = doubled - 9;
                } else {
                    arrDigit[i] = doubled;
                }
                
                isSecond = false;
            } else {
                isSecond = true;
            }
            
            total += arrDigit[i];
        }
        
        String strTotal = Integer.toString(total);
        int lastDigit = Integer.parseInt(String.valueOf(strTotal.charAt(strTotal.length()-1)));
        
        if(lastDigit > 0) {
            return 10 - lastDigit;
        } else {
            return 0;
        }
    }
	
	//format yyyy-mm-dd (e.g. 2021-09-13)
	public static String getDateString(Calendar calendar) {
		StringBuilder sb = new StringBuilder();
        
        int year = calendar.get(Calendar.YEAR);
        sb.append(year);
        
        int month = calendar.get(Calendar.MONTH)+1;
        sb.append("-").append((month < 10) ? "0" : "").append(month);
        
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        sb.append("-").append((day < 10) ? "0" : "").append(day);
        
        return sb.toString();
	}
	
	public static HashMap<String, Object> copyHashMap(HashMap<String, Object> map) {
		HashMap<String, Object> newMap  = new HashMap<String, Object>();
		
		for(Map.Entry<String, Object> set : map.entrySet()) {
			newMap.put(set.getKey(), set.getValue());
		}
		
		return newMap;
	}
}
