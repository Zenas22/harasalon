--
-- PostgreSQL database dump
--

-- Dumped from database version 11.3 (Ubuntu 11.3-1.pgdg18.04+1)
-- Dumped by pg_dump version 11.3 (Ubuntu 11.3-1.pgdg18.04+1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: clients; Type: TABLE; Schema: public; Owner: zeus
--

CREATE TABLE public.clients (
    id integer NOT NULL,
    name character varying,
    age integer,
    huduma character varying,
    email character varying,
    stylistid integer
);


ALTER TABLE public.clients OWNER TO zeus;

--
-- Name: clients_id_seq; Type: SEQUENCE; Schema: public; Owner: zeus
--

CREATE SEQUENCE public.clients_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.clients_id_seq OWNER TO zeus;

--
-- Name: clients_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: zeus
--

ALTER SEQUENCE public.clients_id_seq OWNED BY public.clients.id;


--
-- Name: stylists; Type: TABLE; Schema: public; Owner: zeus
--

CREATE TABLE public.stylists (
    id integer NOT NULL,
    firstname character varying,
    lastname character varying,
    age integer,
    phone integer,
    huduma character varying,
    email character varying
);


ALTER TABLE public.stylists OWNER TO zeus;

--
-- Name: stylists_id_seq; Type: SEQUENCE; Schema: public; Owner: zeus
--

CREATE SEQUENCE public.stylists_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.stylists_id_seq OWNER TO zeus;

--
-- Name: stylists_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: zeus
--

ALTER SEQUENCE public.stylists_id_seq OWNED BY public.stylists.id;


--
-- Name: clients id; Type: DEFAULT; Schema: public; Owner: zeus
--

ALTER TABLE ONLY public.clients ALTER COLUMN id SET DEFAULT nextval('public.clients_id_seq'::regclass);


--
-- Name: stylists id; Type: DEFAULT; Schema: public; Owner: zeus
--

ALTER TABLE ONLY public.stylists ALTER COLUMN id SET DEFAULT nextval('public.stylists_id_seq'::regclass);


--
-- Data for Name: clients; Type: TABLE DATA; Schema: public; Owner: zeus
--

COPY public.clients (id, name, age, huduma, email, stylistid) FROM stdin;
\.


--
-- Data for Name: stylists; Type: TABLE DATA; Schema: public; Owner: zeus
--

COPY public.stylists (id, firstname, lastname, age, phone, huduma, email) FROM stdin;
\.


--
-- Name: clients_id_seq; Type: SEQUENCE SET; Schema: public; Owner: zeus
--

SELECT pg_catalog.setval('public.clients_id_seq', 54, true);


--
-- Name: stylists_id_seq; Type: SEQUENCE SET; Schema: public; Owner: zeus
--

SELECT pg_catalog.setval('public.stylists_id_seq', 20, true);


--
-- Name: clients clients_pkey; Type: CONSTRAINT; Schema: public; Owner: zeus
--

ALTER TABLE ONLY public.clients
    ADD CONSTRAINT clients_pkey PRIMARY KEY (id);


--
-- Name: stylists stylists_pkey; Type: CONSTRAINT; Schema: public; Owner: zeus
--

ALTER TABLE ONLY public.stylists
    ADD CONSTRAINT stylists_pkey PRIMARY KEY (id);


--
-- PostgreSQL database dump complete
--

