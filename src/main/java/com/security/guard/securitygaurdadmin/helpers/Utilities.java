package com.security.guard.securitygaurdadmin.helpers;

public class Utilities {

	/*
	 * public static Coordinate getPoint(String point) { String[] coord =
	 * point.split(" "); // geeting coordintes from string Coordinate p = new
	 * Coordinate(Double.parseDouble(coord[0].strip()),
	 * Double.parseDouble(coord[1].strip())); return p;
	 * 
	 * }
	 * 
	 * public static Polygon getPolygon(String points) { GeometryFactory
	 * geometryFactory = new GeometryFactory(); List<Coordinate> edges = new
	 * ArrayList<Coordinate>(); String[] data = points.strip().split(","); for
	 * (String point : data) { String[] coord = point.strip().split(" "); Coordinate
	 * p = new Coordinate(Double.parseDouble(coord[0].strip()),
	 * Double.parseDouble(coord[1].strip())); edges.add(p); } // converting list to
	 * array Coordinate[] coords = edges.toArray(new Coordinate[0]); LinearRing ring
	 * = geometryFactory.createLinearRing(coords); LinearRing holes[] = null; // use
	 * LinearRing[] to represent holes Polygon polygon =
	 * geometryFactory.createPolygon(ring, holes); return polygon; }
	 * 
	 * public static boolean getCoverage(List<Polygon> fences, Point point) {
	 * System.err.println(" point " + point); boolean status = false;
	 * 
	 * for (Polygon fence : fences) { if (fence.contains(point)) {
	 * 
	 * status = true; break; } } return status;
	 * 
	 * }
	 */
}
